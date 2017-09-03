package com.jiang.action;
/**
 * 验证码的生成
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PicAction extends HttpServlet {
	private static final long serialVersionUID = -7460049268451120366L;
	private int width=120,height=20;
	private String source="0123456789";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		String checkcode =this.generateCheckcode(6);
		HttpSession session = request.getSession();
		session.setAttribute("checkcode", checkcode);
		g.setColor(Color.red);
		g.setFont(new Font("宋体",Font.BOLD,28));
		g.drawString(checkcode, 10, height-10);
		g.dispose();
		response.resetBuffer();
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cace");
		response.setDateHeader("expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(bi, "jpg", sos);
		sos.flush();
		sos.close();
	}
	
	//获取随机数
	private String generateCheckcode(int len){
		char[] res = new char[len];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			res[i] = source.charAt(r.nextInt(source.length()));
		}
		return new String(res);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String ss = config.getInitParameter("width");
		try {
			width = Integer.parseInt(ss);
		} catch (Exception e) {
			width=120;
		}
		ss = config.getInitParameter("height");
		try {
			height= Integer.parseInt(ss);
		} catch (Exception e) {
			height=20;
		}
	}
}
