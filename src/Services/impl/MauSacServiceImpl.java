/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.MauSac;
import Repostorities.MauSacRepoStority;
import Repostorities.impl.MauSacRepoStorityImpl;
import Services.MauSacService;
import java.util.List;

/**
 *
 * @author pc
 */
public class MauSacServiceImpl implements MauSacService {

    MauSacRepoStority mauSacRepo = new MauSacRepoStorityImpl();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepo.getAll();
    }

    public boolean addMau(MauSac mau) {
        return mauSacRepo.addMau(mau);
    }

    public boolean updateMau(MauSac mau) {
        return mauSacRepo.updateMau(mau);
    }

    public boolean deleteMau(MauSac mau) {
        return mauSacRepo.deleteMau(mau);
    }
}
