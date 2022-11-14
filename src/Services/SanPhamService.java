/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.sanPham;
import java.util.List;

/**
 *
 * @author pc
 */
public interface SanPhamService {

    List<sanPham> getAll();

    String addSanPham(sanPham sp);

    String updateSanPham(String id, sanPham sp);

    String deleteSanPham(String id);
}
