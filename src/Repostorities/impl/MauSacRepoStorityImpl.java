/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import DomainModels.MauSac;
import Repostorities.MauSacRepoStority;
import java.util.List;
import Utilities.DBContext;;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class MauSacRepoStorityImpl implements MauSacRepoStority {

    @Override
    public List<MauSac> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                         FROM [dbo].[MauSac]
                       """;
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<MauSac> listMauSac = new ArrayList<>();
            while (rs.next()) {
                MauSac mauSac = new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
                listMauSac.add(mauSac);
            }
            return listMauSac;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addMau(MauSac mau) {
//        int check = 0;
        String sql = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mau.getMa());
            ps.setObject(2, mau.getTen());
            ps.executeUpdate();
            //Nếu câu query thành công thì check =1
            //Trả ra 1 khi thành công và 0 khi thất bại
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        //Nếu thành công thì check >1 
        //return 1>0; = return true;
        //Nếu thất bại thì check 0=0
        //Return 0>0 ; = return false;
//        return check > 0;
        return true;
    }

    @Override
    public boolean deleteMau(MauSac mau) {
        int check = 0;
        String sql = "Delete from MauSac where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mau.getId());
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
    public boolean updateMau(MauSac mau) {
        int check = 0;
        String sql = "Update  MauSac set ma = ?, ten = ? where id = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mau.getMa());
            ps.setObject(2, mau.getTen());
            ps.setObject(3, mau.getId());
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
