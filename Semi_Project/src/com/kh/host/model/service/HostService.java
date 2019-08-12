package com.kh.host.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.host.model.dao.HostDAO;

public class HostService {

	public List<SpaceAll> selectSpaceListByHostId(String hostId) {
		Connection conn = getConnection();
		List<SpaceAll> hostSpaceList = new HostDAO().selectSpaceListByHostId(conn, hostId);
		close(conn);
		return hostSpaceList;
	}
	
}
