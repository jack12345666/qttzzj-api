package com.vpn.website.common.filter;

import java.io.Serializable;

/**
 * @author wzh
 * @date 2020/4/30 23:38
 * 普通用户授权信息
 */
public class AuthInfoDTO implements Serializable {
    /**
     * token : wwrHLOyHC3I3nEJCs6p+jSHoPM0DrtjgloLz9MDpboF9gsFEb31FD3LPJdeEhUwFkHAl2UX3hAvz
     zz9/jenkQlEvysasFreoidYUgSFQVFw=
     * code : 0
     * character : {"id":1,"no":"a123456","name":"张强","avatar":"/companyHome/userHead/15/3/84323231-3457-48d0-99e2-df50991aae34.jpg"}
     */
    private String token;
    private String code;
    private AuthInfo character;
    private PerListBean perList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AuthInfo getCharacter() {
        return character;
    }

    public void setCharacter(AuthInfo character) {
        this.character = character;
    }

    public static class PerListBean {
        /**
         * perAuditStoreGoods : false
         * perAuditStore : false
         */

        private boolean perAuditStoreGoods;
        private boolean perAuditStore;

        public boolean isPerAuditStoreGoods() {
            return perAuditStoreGoods;
        }

        public void setPerAuditStoreGoods(boolean perAuditStoreGoods) {
            this.perAuditStoreGoods = perAuditStoreGoods;
        }

        public boolean isPerAuditStore() {
            return perAuditStore;
        }

        public void setPerAuditStore(boolean perAuditStore) {
            this.perAuditStore = perAuditStore;
        }
    }

    public PerListBean getPerList() {
        return perList;
    }

    public void setPerList(PerListBean perList) {
        this.perList = perList;
    }
}
