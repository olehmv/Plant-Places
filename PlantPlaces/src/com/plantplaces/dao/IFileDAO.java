package com.plantplaces.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileDAO {

	void save(InputStream inputSteam, File file) throws IOException;

}