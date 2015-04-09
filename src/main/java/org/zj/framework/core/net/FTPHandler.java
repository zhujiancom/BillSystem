/**
 * 
 */
package org.zj.framework.core.net;

import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.OutputStream;

import org.zj.framework.core.exception.ToolsException;

/**
 * @Description 和FTP server 交互的操作类
 * @author zj
 * @Date 2014年11月12日
 *	
 */
public interface FTPHandler{
	public boolean upload(File localFile) throws ToolsException;
	public boolean upload(File localFile,FileFilter filter) throws ToolsException;

	public boolean upload(File[] localFiles) throws ToolsException;
	public boolean upload(File[] localFiles,FileFilter filter) throws ToolsException;

	public boolean upload(String remoteFileName,InputStream in) throws ToolsException;

	public boolean download(String remoteFile,OutputStream output) throws ToolsException;
	public boolean download(String remoteFile,String localFile) throws ToolsException;
	public boolean download(String[] remoteFiles, File localDir) throws ToolsException;

	public boolean makeDirectory(String dirName) throws ToolsException;

}
