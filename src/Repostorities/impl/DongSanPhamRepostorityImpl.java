/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import DomainModels.CTSanPham;
import DomainModels.DongSanPham;
import Repostorities.DongSanPhamRepostority;
import Utilities.DBContext;
import Viewmodels.CTSanPhamReposton;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DongSanPhamRepostorityImpl implements DongSanPhamRepostority {

    @Override
    public List<DongSanPham> getAll() {

        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[DongSP] 
                       """;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<DongSanPham> listDongSanPham = new ArrayList<>();
            while (rs.next()) {
                DongSanPham dongSanPham = new DongSanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                listDongSanPham.add(dongSanPham);
            }
            return listDongSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addDong(DongSanPham dsp) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
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

    @Override
    public boolean updateDong(DongSanPham dsp) {
        int check = 0;
        String sql = "Update  DongSP set ma = ?, ten = ? where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
            ps.setObject(3, dsp.getId());
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

    @Override
    public boolean deleteDong(DongSanPham dsp) {
        int check = 0;
        String sql = "Delete from DongSP where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dsp.getId());
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
