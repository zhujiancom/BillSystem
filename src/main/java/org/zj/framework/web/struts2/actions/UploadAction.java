/**
 * 
 */
package org.zj.framework.web.struts2.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.zj.framework.core.net.FTPHandler;

/**
 * @Description
 * @author zj
 * @Date 2014年11月4日
 *	
 */
public abstract class UploadAction extends Struts2DefaultAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8480903108899465984L;

	private static final Log logger = LogFactory.getLog(UploadAction.class);

	/*定义缓冲区大小16M*/
	private static final int BUFFER_SIZE = 16*1024;

	//multiple file upload
	private File[] imageFiles;
	private String[] imageFilesContentType;
	private String[] imageFilesFileName;

	protected void uploadToWebServer(){
		String dirPath = getUploadPath();
		checkDir(dirPath);
		for(int i=0;i<imageFiles.length;i++){
			String imageName = UUID.randomUUID().toString();
			String fileType = getExtention(imageFilesFileName[i]);
			String imageFilePath = dirPath+File.separator+imageName+fileType;
			File destFile = new File(imageFilePath);
			//			copyByChannel(imageFiles[i],destFile);
			try{
				FileUtils.copyFile(imageFiles[i],destFile);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	protected void uploadToFTPServer(){

	}

	private void checkDir(String dirPath){
		File dir = new File(dirPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
	}

	protected void copyByChannel(File src,File dest){
		FileInputStream fin = null;
		FileOutputStream fout = null;
		FileChannel fcin = null;
		FileChannel fcout = null;
		try {
			fin = new FileInputStream(src);
			fout = new FileOutputStream(dest);
			fcin = fin.getChannel();
			fcout = fout.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
			while(true){
				buffer.clear();
				int r = fcin.read(buffer); //判断拷贝完成
				if(r ==-1){
					break;
				}
				buffer.flip();
				fcout.write(buffer);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally{
			try {
				if(fin != null){
					fin.close();
				}
				if(fout != null){
					fout.close();
				}
				fcin.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getExtention(String fileName){
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public boolean isAbsolutePath(String destination){
		String os = System.getProperty("os.name");
		logger.debug("os = "+os);
		// windows 下
		if(os.startsWith("win") || os.startsWith("Win")){
			if(destination.indexOf(":") != -1){ //D://uploadFile
				return true;
			}
		}
		// linux 下
		if(destination.startsWith(File.separator)){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Function 获取本地文件系统格式的绝对路径
	 * @return
	 * @author zj
	 * @Date 2014年11月10日
	 */
	public String getLocalRootPath(){
		String absolutePath = ServletActionContext.getServletContext().getRealPath("/");
		logger.debug("absolutePath = "+absolutePath);
		return absolutePath;
	}

	/**
	 * 
	 * @Function 获取server端路径
	 * @return
	 * @author zj
	 * @Date 2014年11月10日
	 */
	public String getWebRootPath(){
		String scheme = ServletActionContext.getRequest().getScheme(); // http
		String contextPath = ServletActionContext.getRequest().getContextPath();  // project name
		String serverName = ServletActionContext.getRequest().getServerName(); //localhost
		int port = ServletActionContext.getRequest().getServerPort(); // 8080
		String rootPath = scheme+"://"+serverName+":"+port+contextPath+"/";
		logger.debug("webrootPath = "+rootPath);
		return rootPath;
	}

	protected abstract String getDestinationPath();

	protected FTPHandler getFtpOp(){
		return null;
	};

	public String getUploadPath(){
		if(isAbsolutePath(getDestinationPath())){
			return getDestinationPath();
		}
		return getLocalRootPath()+File.separator+getDestinationPath();
	}

	public File[] getImageFiles(){
		return this.imageFiles;
	}


	public void setImageFiles(File[] imageFiles){
		this.imageFiles = imageFiles;
	}


	public String[] getImageFilesContentType(){
		return this.imageFilesContentType;
	}


	public void setImageFilesContentType(String[] imageFilesContentType){
		this.imageFilesContentType = imageFilesContentType;
	}


	public String[] getImageFilesFileName(){
		return this.imageFilesFileName;
	}


	public void setImageFilesFileName(String[] imageFilesFileName){
		this.imageFilesFileName = imageFilesFileName;
	}
}
