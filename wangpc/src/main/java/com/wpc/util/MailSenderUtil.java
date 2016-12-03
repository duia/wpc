/**  
 * @Title:  MailSenderUtil.java   
 * @Package com.wpc.util   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangpengcheng     
 * @date:   2016年12月2日 下午6:52:02   
 * @version V1.0 
 */
package com.wpc.util;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**   
 * @ClassName:  MailSenderUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: wangpengcheng 
 * @date:   2016年12月2日 下午6:52:02   
 *     
 */
@Component
public class MailSenderUtil {

	@Resource
	private static JavaMailSenderImpl mailSender;
	
	public static void send() throws MessagingException{
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
		helper.setFrom("wpcfree@qq.com");  
		helper.setTo("376205421@qq.com");  
		helper.setSubject("邮箱测试");  
		helper.setText("test,中文测试");
        mailSender.send(message);
	}
}
