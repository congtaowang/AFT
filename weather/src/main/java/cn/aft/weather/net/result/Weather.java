package cn.aft.weather.net.result;

import java.util.List;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0<P></P>
 * Generate by GSonFormatter
 */
public class Weather {

    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"19","ganmao":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。","forecast":[{"fengxiang":"西北风","high":"高温 22℃","fengli":"微风","date":"24日星期三","low":"低温 19℃","type":"小雨"},{"fengxiang":"西北风","high":"高温 23℃","fengli":"微风","date":"25日星期四","low":"低温 19℃","type":"多云"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"26日星期五","low":"低温 18℃","type":"小雨"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"27日星期六","low":"低温 18℃","type":"晴"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"28日星期天","low":"低温 18℃","type":"多云"}],"yesterday":{"fl":"3-4级","fx":"北风","high":"高温 25℃","date":"23日星期二","low":"低温 19℃","type":"小雨"},"city":"嘉义"}
     */
    private String desc;
    private int status;
    private DataEntity data;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * wendu : 19
         * ganmao : 天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。
         * forecast : [{"fengxiang":"西北风","high":"高温 22℃","fengli":"微风","date":"24日星期三","low":"低温 19℃","type":"小雨"},{"fengxiang":"西北风","high":"高温 23℃","fengli":"微风","date":"25日星期四","low":"低温 19℃","type":"多云"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"26日星期五","low":"低温 18℃","type":"小雨"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"27日星期六","low":"低温 18℃","type":"晴"},{"fengxiang":"西北风","high":"高温 24℃","fengli":"微风","date":"28日星期天","low":"低温 18℃","type":"多云"}]
         * yesterday : {"fl":"3-4级","fx":"北风","high":"高温 25℃","date":"23日星期二","low":"低温 19℃","type":"小雨"}
         * city : 嘉义
         */
        private String wendu;
        private String ganmao;
        private List<ForecastEntity> forecast;
        private YesterdayEntity yesterday;
        private String city;

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public void setForecast(List<ForecastEntity> forecast) {
            this.forecast = forecast;
        }

        public void setYesterday(YesterdayEntity yesterday) {
            this.yesterday = yesterday;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getWendu() {
            return wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public List<ForecastEntity> getForecast() {
            return forecast;
        }

        public YesterdayEntity getYesterday() {
            return yesterday;
        }

        public String getCity() {
            return city;
        }

        public class ForecastEntity {
            /**
             * fengxiang : 西北风
             * high : 高温 22℃
             * fengli : 微风
             * date : 24日星期三
             * low : 低温 19℃
             * type : 小雨
             */
            private String fengxiang;
            private String high;
            private String fengli;
            private String date;
            private String low;
            private String type;

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getHigh() {
                return high;
            }

            public String getFengli() {
                return fengli;
            }

            public String getDate() {
                return date;
            }

            public String getLow() {
                return low;
            }

            public String getType() {
                return type;
            }

            @Override
            public String toString() {
                return "ForecastEntity{" +
                        "fengxiang='" + fengxiang + '\'' +
                        ", high='" + high + '\'' +
                        ", fengli='" + fengli + '\'' +
                        ", date='" + date + '\'' +
                        ", low='" + low + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }

        public class YesterdayEntity {
            /**
             * fl : 3-4级
             * fx : 北风
             * high : 高温 25℃
             * date : 23日星期二
             * low : 低温 19℃
             * type : 小雨
             */
            private String fl;
            private String fx;
            private String high;
            private String date;
            private String low;
            private String type;

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getFl() {
                return fl;
            }

            public String getFx() {
                return fx;
            }

            public String getHigh() {
                return high;
            }

            public String getDate() {
                return date;
            }

            public String getLow() {
                return low;
            }

            public String getType() {
                return type;
            }

            @Override
            public String toString() {
                return "YesterdayEntity{" +
                        "fl='" + fl + '\'' +
                        ", fx='" + fx + '\'' +
                        ", high='" + high + '\'' +
                        ", date='" + date + '\'' +
                        ", low='" + low + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "desc='" + desc + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
