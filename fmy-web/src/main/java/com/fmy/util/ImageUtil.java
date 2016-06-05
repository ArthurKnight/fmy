package com.fmy.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtil {
	
	@SuppressWarnings("restriction")
	public static String base64ToImage(String photo,String picturePath) {
		BASE64Decoder decoder = new BASE64Decoder();
		String photo_path = null ;
		ByteArrayInputStream bais = null ;
		String photo_name = null ;
		try {     
			photo_name = new Date().getTime()+".jpg" ;
			photo_path = picturePath+photo_name;	
		    byte[] bytes1 = decoder.decodeBuffer(photo);  
			bais = new ByteArrayInputStream(bytes1);      
			BufferedImage bi = ImageIO.read(bais) ;
			File w = new File(photo_path);
			ImageIO.write(bi, "jpg", w);
			bais.close();
		} catch (IOException e) {      
			e.printStackTrace();      
		}
		return "/images/uploadPic/"+photo_name;
	}
	
	/**
	 * 从path这个地址获取一张图片然后转为base64码
	 * 
	 * @param imgName
	 *            图片的名字 如：123.gif（是带后缀的）
	 * @param path
	 *            123.gif图片存放的路径
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static String getImageFromServer(String imgName, String path)
			throws Exception {
		@SuppressWarnings("restriction")
		BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		File f = new File(path + imgName);
		
		BufferedImage bi = ImageIO.read(f);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi, "jpg", baos);
		byte[] bytes = baos.toByteArray();
		return encoder.encodeBuffer(bytes).trim();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getImageFromServer("Korla.jpg", "C:/Users/Public/Pictures/Sample Pictures/"));
	}
}
