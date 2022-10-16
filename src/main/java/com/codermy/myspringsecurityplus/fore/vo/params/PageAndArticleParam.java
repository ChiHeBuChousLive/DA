package com.codermy.myspringsecurityplus.fore.vo.params;

import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import lombok.Data;

//这个类是由于前端post传回请求数据的时候只能传回一个类，所以创建这个类用于接收数据
@Data
public class PageAndArticleParam {
    private PageTableRequest pageTableRequest;
    private ArticleQueryDto articleQueryDto;
}
