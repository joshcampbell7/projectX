package com.project.socialMedia.repository;

import com.project.socialMedia.model.userAccount;
import org.springframework.data.repository.CrudRepository;

public interface userAccountRepo extends CrudRepository<userAccount,String> {
}
