package com.services.managers.owner;

import com.services.dtoModels.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOwnerManager {
    OwnerDTO Get(String id);
    List<OwnerDTO> GetAll();
    OwnerDTO Create(OwnerDTO newOwner);
    OwnerDTO Update(OwnerDTO updatedOwner, String id);
    OwnerDTO Delete(String id);

    List<OwnerDTO> GetAllFromIdList(List<String> idList);
}
