/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.KhachHang;
import Repostorities.impl.KhachHangRepositoryImpl;
import Repostorities.khachHangRepository;
import Services.KhachHangService;
import java.util.List;

/**
 *
 * @author pc
 */
public class KhachHangServiceImpl implements KhachHangService {

    private khachHangRepository khachHangRepo = new KhachHangRepositoryImpl();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepo.getAll();
    }

//    @Override
    public String add(KhachHang kh) {
        boolean addKhachHang = khachHangRepo.add(kh);
        if (addKhachHang) {
            return "thêm thành công";
        }
        return "thêm thất bại";
    }

    @Override
    public String update(String id, KhachHang kh) {
        boolean updateKhachHang = khachHangRepo.update(id, kh);
        if (updateKhachHang) {
            return "sửa thành công";
        }
        return "sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteKhachHang = khachHangRepo.delete(id);
        if (deleteKhachHang) {
            return "Xóa thành công id" + id;
        }
        return "Xóa thất bại";
    }

}
