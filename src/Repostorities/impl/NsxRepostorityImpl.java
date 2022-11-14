/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import DomainModels.MauSac;
import DomainModels.Nsx;
import Repostorities.NSXRepostority;
import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class NsxRepostorityImpl implements NSXRepostority {

    @Override
    public List<Nsx> getAll() {
        String query = """
                       SELECT [Id]
                               ,[Ma]
                               ,[Ten]
                           FROM [dbo].[NSX]
                       """;
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Nsx> listNsx = new ArrayList<>();
            while (rs.next()) {
                Nsx nsx = new Nsx(rs.getString(1), rs.getString(2), rs.getString(3));
                listNsx.add(nsx);
            }
            return listNsx;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addNsx(Nsx nsx) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[NSX]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
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
    public boolean deleteNsx(Nsx nsx) {
        int check = 0;
        String sql = "Delete from NSX where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nsx.getId());
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
    public boolean updateNsx(Nsx nsx) {
        int check = 0;
        String sql = "Update  NSX set ma = ?, ten = ? where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            ps.setObject(3, nsx.getId());
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
