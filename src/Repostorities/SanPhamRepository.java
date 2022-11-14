/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.sanPham;
import java.util.List;

/**
 *
 * @author pc
 */
public interface SanPhamRepository {

    List<sanPham> getAll();

    boolean addSanPham(sanPham sp);

    boolean updateSanPham(String id, sanPham sp);

    boolean deleteSanPham(String id);
}
