/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.DongSanPham;
import Repostorities.DongSanPhamRepostority;
import Repostorities.impl.DongSanPhamRepostorityImpl;
import Services.DongSanPhamService;
import java.util.List;

/**
 *
 * @author pc
 */
public class DongSanPhamServiceImpl implements DongSanPhamService {

    DongSanPhamRepostority DongSPRepo = new DongSanPhamRepostorityImpl();

    @Override
    public List<DongSanPham> getAll() {
        return DongSPRepo.getAll();
    }

    @Override
    public boolean addDong(DongSanPham dsp) {
        return DongSPRepo.addDong(dsp);
    }

    @Override
    public boolean deleteDong(DongSanPham dsp) {
        return DongSPRepo.deleteDong(dsp);
    }

    @Override
    public boolean updateDong(DongSanPham dsp) {
        return DongSPRepo.updateDong(dsp);
    }

}
