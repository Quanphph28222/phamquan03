/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.CTHoaDon;
import Repostorities.CTHoaDonRepository;
import Repostorities.impl.CTHoaDonRepositoryImpl;
import java.util.List;

/**
 *
 * @author pc
 */
public class CTHoaDonServiceImpl implements Services.CTHoaDonService {

    private CTHoaDonRepository CTHoaDonRepo = new CTHoaDonRepositoryImpl();

    @Override
    public List<CTHoaDon> getAll() {
        return CTHoaDonRepo.getAll();
    }

    @Override
    public String addHoaDon(CTHoaDon cthd) {
        boolean addcthd = CTHoaDonRepo.addHoaDon(cthd);
        if (addcthd) {
            return "Thêm hóa đơn thành công";
        }
        return "Thêm hóa đơn thất bại";
    }

    @Override
    public String updateHoaDon(String id, CTHoaDon cthd) {
        boolean addcthd = CTHoaDonRepo.updateHoaDon(id, cthd);
        if (addcthd) {
            return "Sửa hóa đơn thành công";
        }
        return "Sửa hóa đơn thất bại";
    }

    @Override
    public String delete(String id) {
        boolean addcthd = CTHoaDonRepo.deleteHoaDon(id);
        if (addcthd) {
            return "Xóa hóa đơn thành công";
        }
        return "Xóa hóa đơn thất bại";
    }

}
