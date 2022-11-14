/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.DongSanPham;
import java.util.List;

/**
 *
 * @author pc
 */
public interface DongSanPhamRepostority {

    List<DongSanPham> getAll();

    boolean addDong(DongSanPham dsp);

    boolean updateDong(DongSanPham dsp);

    boolean deleteDong(DongSanPham dsp);

}
