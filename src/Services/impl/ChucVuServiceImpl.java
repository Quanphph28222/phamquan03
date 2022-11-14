/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.ChucVu;
import Repostorities.ChucVuRepostority;
import Repostorities.impl.ChucVuRepostorityImpl;
import Services.ChucVuService;
import java.util.List;

/**
 *
 * @author pc
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepostority chucVuRepository = new ChucVuRepostorityImpl();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOne(String id) {
        return chucVuRepository.getOne(id);
    }

    @Override
    public String add(ChucVu chucVu) {
        boolean addChucVu = chucVuRepository.add(chucVu);
        if(addChucVu){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, ChucVu chucVu) {
        boolean updateChucVu = chucVuRepository.update(id, chucVu);
        if(updateChucVu){
            return "Sửa thành công id"+ id ;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteChucVu = chucVuRepository.delete(id);
        if(deleteChucVu){
            return "Xóa thành công id"+ id ;
        }
        return "Xóa thất bại";
    }
}
