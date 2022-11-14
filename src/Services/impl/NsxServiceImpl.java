/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.Nsx;
import Repostorities.NSXRepostority;
import Repostorities.impl.NsxRepostorityImpl;
import Services.NsxService;
import java.util.List;

/**
 *
 * @author pc
 */
public class NsxServiceImpl implements NsxService {

    NSXRepostority NsxRepo = new NsxRepostorityImpl();

    @Override
    public List<Nsx> getAll() {
        return NsxRepo.getAll();
    }

    @Override
    public boolean addNsx(Nsx nsx) {
        return NsxRepo.addNsx(nsx);
    }

    @Override
    public boolean deleteNsx(Nsx nsx) {
        return NsxRepo.deleteNsx(nsx);
    }

    @Override
    public boolean updateNsx(Nsx nsx) {
        return NsxRepo.updateNsx(nsx);
    }

}
