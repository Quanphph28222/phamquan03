/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import DomainModels.CuaHang;
import Repostorities.CuaHangReposotority;
import Viewmodels.CuaHangResponse;
import java.util.List;
import Utilities.DBContext;
import Viewmodels.CTSanPhamReposton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class CuaHangRepostorityImpl implements CuaHangReposotority {

    @Override
    public List<CuaHangResponse> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[DiaChi]
                             ,[ThanhPho]
                             ,[QuocGia]
                         FROM [dbo].[CuaHang]  
                       """;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<CuaHangResponse> listCuaHang = new ArrayList<>();
            while (rs.next()) {
                CuaHangResponse cuaHangResponse = new CuaHangResponse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listCuaHang.add(cuaHangResponse);
            }
            return listCuaHang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(CuaHang CuaHang) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[CuaHang]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[DiaChi]\n"
                + "           ,[ThanhPho]\n"
                + "           ,[QuocGia])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, CuaHang.getMa());
            ps.setObject(2, CuaHang.getTen());
            ps.setObject(3, CuaHang.getDiaChi());
            ps.setObject(4, CuaHang.getThanhPho());
            ps.setObject(5, CuaHang.getQuocGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[CuaHang]\n"
                + "      WHERE id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, CuaHang CuaHang) {
        int check = 0;
        String sql = "UPDATE [dbo].[CuaHang]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[Ten] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[ThanhPho] = ?\n"
                + "      ,[QuocGia] = ?\n"
                + " WHERE id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, CuaHang.getMa());
            ps.setObject(2, CuaHang.getTen());
            ps.setObject(3, CuaHang.getDiaChi());
            ps.setObject(4, CuaHang.getThanhPho());
            ps.setObject(5, CuaHang.getQuocGia());
            ps.setObject(6, id);
            check = ps.executeUpdate();
            //Nếu câu query thành công thì check =1
            //Trả ra 1 khi thành công và 0 khi thất bại
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        //Nếu thành công thì check >1 
        //return 1>0; = return true;
        //Nếu thất bại thì check 0=0
        //Return 0>0 ; = return false;
        return check > 0;
    }

}
