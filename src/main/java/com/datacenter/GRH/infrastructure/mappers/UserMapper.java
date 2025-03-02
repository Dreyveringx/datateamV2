package com.datacenter.GRH.infrastructure.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.datacenter.GRH.domain.models.Company;
import com.datacenter.GRH.domain.models.Nationality;
import com.datacenter.GRH.domain.models.Parameter;
import com.datacenter.GRH.domain.models.Position;
import com.datacenter.GRH.domain.models.Role;
import com.datacenter.GRH.domain.models.User;
import com.datacenter.GRH.domain.models.UserStatus;
import com.datacenter.GRH.infrastructure.adapters.in.rest.controllers.requests.RegisterUserRequest;
import com.datacenter.GRH.infrastructure.adapters.in.rest.controllers.responses.UserResponse;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(source = "email", target = "email")
    @Mapping(target = "firstName", constant = "Usuario")
    @Mapping(target = "lastName", constant = "No definido")
    @Mapping(target = "roles", ignore = true) // Se asignará después
    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "documentIssueCity", ignore = true)
    @Mapping(target = "documentIssueDate", ignore = true)
    @Mapping(target = "documentType", ignore = true)
    @Mapping(target = "email2", ignore = true)
    @Mapping(target = "hasChildren", ignore = true)
    @Mapping(target = "hasHouse", ignore = true)
    @Mapping(target = "idDocumentType", ignore = true)
    @Mapping(target = "maritalStatus", ignore = true)
    @Mapping(target = "nationality", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "activationToken", ignore = true) 
    @Mapping(target = "resetToken", ignore = true) 
    public abstract User toUser(RegisterUserRequest request);

    public abstract UserResponse toResponse(User user);

    protected List<String> mapRoleNames(List<Role> roles) {
        return roles == null ? null : roles.stream().map(Role::getName).collect(Collectors.toList());
    }

    // Métodos para convertir objetos a String
    protected String mapCompany(Company company) {
        return company != null ? company.getName() : null;
    }

    protected String mapNationality(Nationality nationality) {
        return nationality != null ? nationality.getName() : null;
    }

    protected String mapStatus(UserStatus status) {
        return status != null ? status.getName() : null;
    }

    protected String mapParameter(Parameter parameter) {
        return parameter != null ? parameter.getName() : null;
    }

    protected String mapPosition(Position position) {
        return position != null ? position.getName() : null;
    }
}




