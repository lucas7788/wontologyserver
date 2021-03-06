/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 * The ontology is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ontology is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.github.ontio.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author zhouq
 * @date 2018/2/27
 */

@Service("ConfigParam")
public class ConfigParam {

    @Value("${node.interruptTime.max}")
    public int NODE_INTERRUPTTIME_MAX;

    @Value("${node.waitForBlockTime.max}")
    public int NODE_WAITFORBLOCKTIME_MAX;

    @Value("${block.interval}")
    public int BLOCK_INTERVAL;
    
    @Value("${pageSize}")
    public int pageSize;

    @Value("${hugeWinSize}")
    public int hugeWinSize;

    @Value("${mainchain.rpc.url}")
    public String MAINCHAIN_RPC_URL;

    @Value("${node.amount}")
    public int NODE_AMOUNT;

    @Value("${threadPoolSize.max}")
    public int THREADPOOLSIZE_MAX;

    @Value("${threadPoolSize.core}")
    public int THREADPOOLSIZE_CORE;

    @Value("${threadPoolSize.queue}")
    public int THREADPOOLSIZE_QUEUE;

    @Value("${threadPoolSize.keepalive.second}")
    public int THREADPOOLSIZE_KEEPALIVE_SECOND;

}