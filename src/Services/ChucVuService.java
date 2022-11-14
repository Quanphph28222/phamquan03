/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    String add(ChucVu chucVu);

    String update(String id, ChucVu chucVu);

    String delete(String id);
}
