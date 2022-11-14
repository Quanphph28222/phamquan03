/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.DongSanPham;
import java.util.List;

/**
 *
 * @author pc
 */
public interface DongSanPhamService {

    List<DongSanPham> getAll();

    boolean addDong(DongSanPham dsp);

    boolean deleteDong(DongSanPham dsp);

    boolean updateDong(DongSanPham dsp);

}
