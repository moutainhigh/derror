/*
 * Copyright 2018 org.jfaster.derror.
 *   <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */


package org.jfaster.derror.manager.dao;

import org.jfaster.derror.manager.constant.DbConstant;
import org.jfaster.derror.manager.pojo.domain.ExceptionLogDO;
import org.jfaster.derror.manager.pojo.dto.dingding.ExceptionLogDTO;
import org.jfaster.derror.manager.pojo.vo.ExceptionLogStaticVO;
import org.jfaster.derror.manager.pojo.vo.ExceptionLogVO;

import java.util.List;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.crud.CrudDao;

/**
 * @program: derror
 * @description: 异常信息表
 * @author: Amos.Wxz
 * @create: 2018-07-09 17:36
 **/
@DB(name = DbConstant.DB, table = "exception_log")
public interface ExceptionLogDAO extends CrudDao<ExceptionLogDO, Long> {

    /**
     * 查询异常里边
     *
     * @param exceptionLogDTO
     * @return
     */
    @SQL("select * from #table  where  1=1 "
            + " #if(:1.host!='' && :1.host!=null )  and  host like :1.host  #end  "
            + " #if(:1.appId!=null  ) and  app_id=:1.appId  #end "
            + " #if(:1.startTime!='' && :1.startTime!=null) and  create_date>=:1.startTime  and "
            + "create_date<=:1.endTime #end "
            + "  order by create_date desc ")
    List<ExceptionLogVO> queryExceptions(ExceptionLogDTO exceptionLogDTO);

    /**
     * 删除数据
     *
     * @param format
     * @param format1
     */
    @SQL("delete  from  #table where  create_date>=:1 AND create_date<:2")
    void delExceptionLogs(String format, String format1);

    /**
     * 异常统计
     *
     * @return
     */
    @SQL("select short_name,count(*) as count from exception_log group by short_name")
    List<ExceptionLogStaticVO> queryExceptionStatis();
}
