/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.CTSanPham;
import Repostorities.CTSanPhamRepostority;
import Repostorities.impl.CTSanPhamRepostorityImpl;
import Services.CTSanPhamService;
import Viewmodels.CTSanPhamReposton;
import java.util.List;

/**
 *
 * @author pc
 */
public class CTSanPhamServiceImpl implements CTSanPhamService {

    CTSanPhamRepostority CTSanPhamRepo = new CTSanPhamRepostorityImpl();

    @Override
    public List<CTSanPhamReposton> getAll() {
        return CTSanPhamRepo.getAll();
    }

    @Override
    public CTSanPham getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(CTSanPham ctsp) {
        boolean addCTSanPham = CTSanPhamRepo.add(ctsp);
        if(addCTSanPham){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, CTSanPham ctsp) {
        boolean updateCTSanPham = CTSanPhamRepo.update(id, ctsp);
        if(updateCTSanPham){
            return "Sửa thành công id"+ id ;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteCTSanPham = CTSanPhamRepo.delete(id);
        if(deleteCTSanPham){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }

    

}
