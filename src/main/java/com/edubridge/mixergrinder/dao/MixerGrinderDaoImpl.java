package com.edubridge.mixergrinder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.edubridge.mixergrinder.model.MixerGrinder;
import com.edubridge.mixergrinder.utils.DBUtils;

public class MixerGrinderDaoImpl implements MixerGrinderDao{
    @Override
	public int addMixer(MixerGrinder m) {
		String INSERT = "insert into mixergrinder(name,colour,price) values(?,?,?)";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1,m.getName());
			ps.setString(2,m.getColour());
			ps.setLong(3,m.getPrice());
			
			status = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

    @Override
	public List<MixerGrinder> getAllMixer() {
		String SELECT = "select*from mixergrinder";
		Connection con = DBUtils.getConnection();
		List<MixerGrinder> mixerGrinders = new ArrayList<MixerGrinder>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MixerGrinder MG = new MixerGrinder();
				MG.setId(rs.getInt("id"));
				MG.setName(rs.getString("name"));
				MG.setColour(rs.getString("colour"));
				MG.setPrice(rs.getLong("price"));
				mixerGrinders.add(MG);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return mixerGrinders;
	}


	@Override
	public MixerGrinder getMixer(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updateMixer(MixerGrinder m) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public MixerGrinder searchMixer(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
