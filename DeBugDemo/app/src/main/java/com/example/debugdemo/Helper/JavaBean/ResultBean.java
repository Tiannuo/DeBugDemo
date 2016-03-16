package com.example.debugdemo.Helper.JavaBean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class ResultBean {


    /**
     * result : 0
     * msg : null
     * data : {"cityVOList":[{"showCityName":"杭州","city":{"cityid":2,"proid":11,"cityname":"杭州市","citycode":"330100","areacode":"0571","initials":"","isOpen":true}},{"showCityName":"济南","city":{"cityid":137,"proid":15,"cityname":"济南市","citycode":"370100","areacode":"0531","initials":"","isOpen":true}},{"showCityName":"广州","city":{"cityid":200,"proid":19,"cityname":"广州市","citycode":"440100","areacode":"020","initials":"","isOpen":true}}],"citys":[{"cityid":2,"proid":11,"cityname":"杭州市","citycode":"330100","areacode":"0571","initials":"","isOpen":true},{"cityid":137,"proid":15,"cityname":"济南市","citycode":"370100","areacode":"0531","initials":"","isOpen":true},{"cityid":200,"proid":19,"cityname":"广州市","citycode":"440100","areacode":"020","initials":"","isOpen":true}]}
     */

    private String result;
    private Object msg;
    private DataEntity data;

    public void setResult(String result) {
        this.result = result;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public Object getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * showCityName : 杭州
         * city : {"cityid":2,"proid":11,"cityname":"杭州市","citycode":"330100","areacode":"0571","initials":"","isOpen":true}
         */

        private List<CityVOListEntity> cityVOList;
        /**
         * cityid : 2
         * proid : 11
         * cityname : 杭州市
         * citycode : 330100
         * areacode : 0571
         * initials :
         * isOpen : true
         */

        private List<CitysEntity> citys;

        public void setCityVOList(List<CityVOListEntity> cityVOList) {
            this.cityVOList = cityVOList;
        }

        public void setCitys(List<CitysEntity> citys) {
            this.citys = citys;
        }

        public List<CityVOListEntity> getCityVOList() {
            return cityVOList;
        }

        public List<CitysEntity> getCitys() {
            return citys;
        }

        public static class CityVOListEntity {
            private String showCityName;
            /**
             * cityid : 2
             * proid : 11
             * cityname : 杭州市
             * citycode : 330100
             * areacode : 0571
             * initials :
             * isOpen : true
             */

            private CityEntity city;

            public void setShowCityName(String showCityName) {
                this.showCityName = showCityName;
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public String getShowCityName() {
                return showCityName;
            }

            public CityEntity getCity() {
                return city;
            }

            public static class CityEntity {
                private int cityid;
                private int proid;
                private String cityname;
                private String citycode;
                private String areacode;
                private String initials;
                private boolean isOpen;

                public void setCityid(int cityid) {
                    this.cityid = cityid;
                }

                public void setProid(int proid) {
                    this.proid = proid;
                }

                public void setCityname(String cityname) {
                    this.cityname = cityname;
                }

                public void setCitycode(String citycode) {
                    this.citycode = citycode;
                }

                public void setAreacode(String areacode) {
                    this.areacode = areacode;
                }

                public void setInitials(String initials) {
                    this.initials = initials;
                }

                public void setIsOpen(boolean isOpen) {
                    this.isOpen = isOpen;
                }

                public int getCityid() {
                    return cityid;
                }

                public int getProid() {
                    return proid;
                }

                public String getCityname() {
                    return cityname;
                }

                public String getCitycode() {
                    return citycode;
                }

                public String getAreacode() {
                    return areacode;
                }

                public String getInitials() {
                    return initials;
                }

                public boolean isIsOpen() {
                    return isOpen;
                }
            }
        }

        public static class CitysEntity {
            private int cityid;
            private int proid;
            private String cityname;
            private String citycode;
            private String areacode;
            private String initials;
            private boolean isOpen;

            public void setCityid(int cityid) {
                this.cityid = cityid;
            }

            public void setProid(int proid) {
                this.proid = proid;
            }

            public void setCityname(String cityname) {
                this.cityname = cityname;
            }

            public void setCitycode(String citycode) {
                this.citycode = citycode;
            }

            public void setAreacode(String areacode) {
                this.areacode = areacode;
            }

            public void setInitials(String initials) {
                this.initials = initials;
            }

            public void setIsOpen(boolean isOpen) {
                this.isOpen = isOpen;
            }

            public int getCityid() {
                return cityid;
            }

            public int getProid() {
                return proid;
            }

            public String getCityname() {
                return cityname;
            }

            public String getCitycode() {
                return citycode;
            }

            public String getAreacode() {
                return areacode;
            }

            public String getInitials() {
                return initials;
            }

            public boolean isIsOpen() {
                return isOpen;
            }
        }
    }
}
