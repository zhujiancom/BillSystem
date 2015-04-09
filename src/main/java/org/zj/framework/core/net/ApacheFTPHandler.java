/**
 * 
 */
package org.zj.framework.core.net;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPSClient;
import org.springframework.util.Assert;
import org.zj.framework.core.exception.ExceptionConstant.Tools;
import org.zj.framework.core.exception.ToolsException;

/**
 * @Description
 * @author zj
 * @Date 2014年11月12日
 *	
 */
public class ApacheFTPHandler implements FTPHandler{
	public static final Log logger = LogFactory.getLog(ApacheFTPHandler.class);
	private FTPClient ftpclient;
	private Properties config;


	public ApacheFTPHandler(Properties config){
		this.config  = config;
	}

	/**
	 * 
	 * @Function 连接到  FTP 服务器
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	private void connect() throws ToolsException{
		if(ftpclient != null && ftpclient.isConnected()){
			return ;
		}
		ftpclient = createFTPClient();
	}

	/**
	 * @Function 创建FTPClient实例
	 * @return
	 * @author zj
	 * @Date 2014年11月13日
	 */
	protected FTPClient createFTPClient(){
		Assert.notEmpty(config);
		FTPClient ftpClient = null;
		if(Boolean.TRUE.toString().equalsIgnoreCase(config.getProperty(FTPHandlerConstants.KEY_NEED_SSL))){
			String sslProtocol = this.config.getProperty(FTPHandlerConstants.KEY_SSL_PROTOCOL);
			if(StringUtils.isEmpty(sslProtocol)){
				ftpClient = new FTPSClient(false);
			}else{
				ftpClient = new FTPSClient(sslProtocol,false);
			}
		}
		return ftpClient;
	}

	/**
	 * 
	 * @Function 断开连接
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	private void disconnect() throws ToolsException{
		try{
			this.ftpclient.logout();
		}
		catch(IOException ioe){
			logger.warn(Tools.FTP_DISCONNECT_ERROR,ioe);
		}
		this.ftpclient = null;
	}

	/**
	 * @Function
	 * @param localFile
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean upload(File localFile) throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param localFile
	 * @param filter
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean upload(File localFile,FileFilter filter)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param localFiles
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean upload(File[] localFiles) throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param localFiles
	 * @param filter
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean upload(File[] localFiles,FileFilter filter)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param remoteFileName
	 * @param in
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean upload(String remoteFileName,InputStream in)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param remoteFile
	 * @param output
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean download(String remoteFile,OutputStream output)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param remoteFile
	 * @param localFile
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean download(String remoteFile,String localFile)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param remoteFiles
	 * @param localDir
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean download(String[] remoteFiles,File localDir)
			throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Function
	 * @param dirName
	 * @return
	 * @throws ToolsException
	 * @author zj
	 * @Date 2014年11月13日
	 */
	@Override
	public boolean makeDirectory(String dirName) throws ToolsException{
		// TODO Auto-generated method stub
		return false;
	}
}
