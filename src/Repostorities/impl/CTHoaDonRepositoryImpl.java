/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities.impl;

import DomainModels.CTHoaDon;
import Repostorities.CTHoaDonRepository;
import Utilities.DBContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CTHoaDonRepositoryImpl implements CTHoaDonRepository {

    @Override
    public List<CTHoaDon> getAll() {
        String query = "SELECT [IdHoaDon]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "  FROM [dbo].[HoaDonChiTiet]";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CTHoaDon> listcthd = new ArrayList<>();
            while (rs.next()) {
                CTHoaDon cthd = new CTHoaDon(rs.getString(1), rs.getInt(2), rs.getDouble(3));
                listcthd.add(cthd);
            }
            return listcthd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addHoaDon(CTHoaDon cthd) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cthd.getSoLuong());
            ps.setDouble(2, cthd.getDonGia());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

    @Override
    public boolean updateHoaDon(String id, CTHoaDon cthd) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [SoLuong] = ?\n"
                + "      ,[DonGia] = ?\n"
                + " WHERE id = ? ";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cthd.getSoLuong());
            ps.setDouble(2, cthd.getDonGia());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

    @Override
    public boolean deleteHoaDon(String id) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE id = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

}
