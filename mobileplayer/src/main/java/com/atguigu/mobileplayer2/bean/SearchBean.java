package com.atguigu.mobileplayer2.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：zxn
 * 作用：封装网页返回的json格式数据，进行json解析
 */
public class SearchBean implements Serializable{

    private String flag;
    private String pageNo;
    private String pageSize;
    private String wd;
    private String total;


    private List<ItemData> items;

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    public String getFlag() {
        return flag;
    }

    public String getPageNo() {
        return pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getWd() {
        return wd;
    }

    public String getTotal() {
        return total;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public static class ItemData implements Serializable{
        private String itemID;
        private String itemTitle;
        private String itemType;
        private String detailUrl;
        private String pubTime;
        private String keywords;
        private String category;
        private String guid;
        private String videoLength;
        private String source;
        private String brief;
        private String photoCount;
        private String sub_column_id;
        private String datecheck;
        private ItemImageEntity itemImage;

        public void setItemID(String itemID) {
            this.itemID = itemID;
        }

        public void setItemTitle(String itemTitle) {
            this.itemTitle = itemTitle;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public void setPubTime(String pubTime) {
            this.pubTime = pubTime;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public void setPhotoCount(String photoCount) {
            this.photoCount = photoCount;
        }

        public void setSub_column_id(String sub_column_id) {
            this.sub_column_id = sub_column_id;
        }

        public void setDatecheck(String datecheck) {
            this.datecheck = datecheck;
        }

        public void setItemImage(ItemImageEntity itemImage) {
            this.itemImage = itemImage;
        }

        public String getItemID() {
            return itemID;
        }

        public String getItemTitle() {
            return itemTitle;
        }

        public String getItemType() {
            return itemType;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public String getPubTime() {
            return pubTime;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getCategory() {
            return category;
        }

        public String getGuid() {
            return guid;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public String getSource() {
            return source;
        }

        public String getBrief() {
            return brief;
        }

        public String getPhotoCount() {
            return photoCount;
        }

        public String getSub_column_id() {
            return sub_column_id;
        }

        public String getDatecheck() {
            return datecheck;
        }

        public ItemImageEntity getItemImage() {
            return itemImage;
        }

        public static class ItemImageEntity implements Serializable{
            private String imgUrl1;

            public void setImgUrl1(String imgUrl1) {
                this.imgUrl1 = imgUrl1;
            }

            public String getImgUrl1() {
                return imgUrl1;
            }
        }
    }
}
