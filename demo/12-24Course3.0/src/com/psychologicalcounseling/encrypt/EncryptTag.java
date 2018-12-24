package com.psychologicalcounseling.encrypt;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.psychologicalcounseling.util.EncryUtil;

public class EncryptTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment jf = this.getJspBody();
        StringWriter sw = new StringWriter();
        jf.invoke(sw);
        
        String content = sw.getBuffer().toString();
        
        content = EncryUtil.encrypt(content);
        
        PageContext pageContent = (PageContext) this.getJspContext();
        pageContent.getOut().write(content);

		
	}


}
