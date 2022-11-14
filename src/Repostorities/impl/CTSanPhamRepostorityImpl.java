/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import Repostorities.*;
import DomainModels.CTSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.Nsx;
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
public class CTSanPhamRepostorityImpl implements CTSanPhamRepostority {

    @Override
    public List<CTSanPhamReposton> getAll() {
        String query = """
                       SELECT dbo.ChiTietSP.Id, dbo.DongSP.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, 
                       dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan, dbo.MauSac.Ten AS Expr1
                       FROM     dbo.ChiTietSP INNER JOIN
                                         dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN
                                         dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id
                       """;
        try ( 
                Connection con = DBContext.getConnection();  
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<CTSanPhamReposton> listCTSanPham = new ArrayList<>();
            while (rs.next()) {
                CTSanPhamReposton ctSanPham = new CTSanPhamReposton(rs.getString(1),rs.getString(2) , rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7),rs.getString(8));
                listCTSanPham.add(ctSanPham);
            }
            return listCTSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    

    @Override
    public CTSanPham getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CTSanPham ctsp) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           ([IdDongSP]\n"
                + "           ,[NamBH]\n"
                + "           ,[MoTa]\n"
                + "           ,[SoLuongTon]\n"
                + "           ,[GiaNhap]\n"
                + "           ,[GiaBan]\n"
                + "           ,[IdMauSac])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getIdDongSP());
            ps.setObject(2, ctsp.getNamBH());
            ps.setObject(3, ctsp.getMoTa());
            ps.setObject(4, ctsp.getSoLuongTon());
            ps.setObject(5, ctsp.getGiaNhap());
            ps.setObject(6, ctsp.getGiaBan());
            ps.setObject(7, ctsp.getIdMauSac());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, CTSanPham ctsp) {
        int check = 0;
        String sql = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET \n"
                + "      [IdDongSP] = ? \n"
                + "      ,[NamBH] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[SoLuongTon] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + "      ,[IdMauSac] = ?\n"
                + " WHERE Id= ?";
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ctsp.getIdDongSP());
            ps.setObject(2, ctsp.getNamBH());
            ps.setObject(3, ctsp.getMoTa());
            ps.setObject(4, ctsp.getSoLuongTon());
            ps.setObject(5, ctsp.getGiaNhap());
            ps.setObject(6, ctsp.getGiaBan());
            ps.setObject(7, ctsp.getIdMauSac());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[ChiTietSP]\n"
                + "      WHERE Id = ?";
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
