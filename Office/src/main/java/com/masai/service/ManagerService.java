package com.masai.service;

import com.masai.exception.ManagerException;
import com.masai.model.Manager;

public interface ManagerService {

    Manager registerNewManager(Manager manager) throws ManagerException;
}
