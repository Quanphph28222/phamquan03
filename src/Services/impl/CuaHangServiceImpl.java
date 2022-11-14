/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.CuaHang;
import Repostorities.CuaHangReposotority;
import Repostorities.impl.CuaHangRepostorityImpl;
import Services.CuaHangService;
import Viewmodels.CuaHangResponse;
import java.util.List;

/**
 *
 * @author pc
 */
public class CuaHangServiceImpl implements CuaHangService {

    private CuaHangReposotority CuaHangRepository = new CuaHangRepostorityImpl();

    @Override
    public List<CuaHangResponse> getAll() {
        return CuaHangRepository.getAll();
    }

    @Override
    public String add(CuaHang CuaHang) {
        boolean addCuaHang = CuaHangRepository.add(CuaHang);
        if(addCuaHang){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteCuaHang = CuaHangRepository.delete(id);
        if(deleteCuaHang){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }

    @Override
    public String update(String id, CuaHang CuaHang) {
        boolean updateCuaHang = CuaHangRepository.update(id, CuaHang);
        if(updateCuaHang){
            return "sửa thành công";
        }
        return "sửa thất bại";
    }
}
