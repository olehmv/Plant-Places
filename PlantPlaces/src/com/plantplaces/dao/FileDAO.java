package com.plantplaces.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Named;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@Named
public class FileDAO implements IFileDAO {

	/* (non-Javadoc)
	 * @see com.plantplaces.dao.IFileDAO#save(java.io.InputStream, java.io.File)
	 */
	@Override
	public void save(InputStream inputSteam,File file) throws IOException{
		OutputStream outputStream=new FileOutputStream(file);
		
		IOUtils.copy(inputSteam,outputStream);
			
	}
}
