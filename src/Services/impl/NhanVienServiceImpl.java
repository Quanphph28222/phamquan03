/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.NhanVien;
import Repostorities.NhanhVienRepository;
import Repostorities.impl.NhanVienRepositoryImpl;
import Services.NhanVienService;
import java.util.List;

/**
 *
 * @author pc
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanhVienRepository nhanVienRepo = new NhanVienRepositoryImpl();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepo.getAll();
    }

    @Override
    public String add(NhanVien nv) {
        boolean addNhanVien = nhanVienRepo.add(nv);
        if (addNhanVien) {
            return "Thêm nhân viên thành công";
        }
        return "Thêm nhân viên thất bại";
    }

    @Override
    public String update(String id, NhanVien nv) {
        boolean updateNhanVien = nhanVienRepo.update(id, nv);
        if (updateNhanVien) {
            return "Cập nhập nhân viên thành công";
        }
        return "Cập nhập nhân viên thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteNhanVien = nhanVienRepo.delete(id);
        if (deleteNhanVien) {
            return "Xóa nhân viên thành công";
        }
        return "Xóa nhân viên thất bại";
    }

}
