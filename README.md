# ontologyserver

## Introduction


## 更新说明

增加接口 
`getbankerinvestbypage`
`getbankerwithdrawbypage`
`savebankerinvest`
`savebankerwithdraw`



## 增加接口列表

`banker` 庄家用户名

`pagesize` 按页查询 每页大小

`pagenumber` 按页查询 页数

 
1. `getbankerinvestbypage`    GET

`/getbankerinvestbypage/{banker}/{pagesize}/{pagenumber}`

查询庄家投资信息


请求例子

```http
http://52.77.179.132:443/api/v1/banker/getbankerinvestbypage/s99/3/1
```

响应结果
```json
{
    "Action": "getbankerinvestbypage",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": [
            {
                "time": "2018-12-12 09:33:53.0",
                "banker": "s99",
                "ongAmount": 100
            },
            {
                "time": "2018-12-12 09:33:47.0",
                "banker": "s99",
                "ongAmount": 10
            }
        ]
    }
}
```

2. `getbankerwithdrawbypage`   GET

`/getbankerwithdrawbypage/{banker}/{pagesize}/{pagenumber}`

查询庄家提现记录

请求例子

```http request
http://52.77.179.132:443/api/v1/banker/getbankerwithdrawbypage/s99/3/1
```

响应结果

```json
{
    "Action": "getbankerwithdrawbypage",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": [
            {
                "time": "2018-12-12 09:34:01.0",
                "banker": "s99",
                "ongAmount": 100
            },
            {
                "time": "2018-12-12 09:29:55.0",
                "banker": "s99",
                "ongAmount": 10
            }
        ]
    }
}
```

3. `savebankerinvest`   POST


保存庄家投资记录

请求例子
```http request
http://52.77.179.132:443/api/v1/banker/savebankerinvest
```
参数
```json
{
  "banker": "s99",
  "ongAmount": 100
}
```

响应结果
```json
{
    "Action": "savebankerinvest",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": 1
    }
}
```

4. savebankerwithdraw    POST

保存用户提现记录

请求例子

```http request
http://52.77.179.132:443/api/v1/banker/savebankerwithdraw
```

参数
```json
{
  "banker": "s99",
  "ongAmount": 100
}
```

响应结果
```json
{
    "Action": "savebankerwithdraw",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": 1
    }
}
```


## Api list

1.  api/v1/bets/gethugewinstopbynum/{num}  Get

查询根据payout由大到小排序的前num个赢家信息

请求例子：

```url
http://127.0.0.1:8585/api/v1/bets/gethugewinstopbynum/10
```

响应例子
```json
{
	"Action": "gethugewinstopbynum",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880,
			"id": 6
		}, {
			"bet": 1.0020,
			"bettor": "sss",
			"rollunder": 20,
			"roll": 60,
			"payout": 1200.8800,
			"id": 3
		}]
	}
}
```

2. api/v1/bets/getbetsbypage/{pageSize}/{pageNumber}    Get

根据页的大小以及页数来查询bet信息

请求例子：
```url
http://127.0.0.1:8585/api/v1/bets/getbetsbypage/5/1

```

响应例子：

```json
{
	"Action": "getbetsbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 1.0020,
			"bettor": "sss",
			"rollunder": 20,
			"roll": 60,
			"payout": 1.8800
		}]
	}
}
```


3. api/v1/bets/getmybetsbybettor/{bettor}     Get

根据bettor查询bet信息

请求例子：
```url
http://127.0.0.1:8585/api/v1/bets/getmybets/ssss

```

响应例子：

```json
{
	"Action": "getmybetsbybettor",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}, {
			"bet": 10.0004,
			"bettor": "ssss",
			"rollunder": 10,
			"roll": 90,
			"payout": 2000.8880
		}]
	}
}
```

4. api/v1/bets/getmybetsbypage/{bettor}/{pageSize}/{pageNumber}      Get

根据页的大小以及页数查询我的bet信息


请求例子
```url
http://127.0.0.1:8585/api/v1/bets/getmybetsbypage/sss/3/1
```

响应例子
```json
{
	"Action": "getmybetsbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"bet": 1.0020,
			"bettor": "sss",
			"rollunder": 20,
			"roll": 60,
			"payout": 1.8800
		}, {
			"bet": 1.0020,
			"bettor": "sss",
			"rollunder": 20,
			"roll": 60,
			"payout": 1000.8800
		}, {
			"bet": 1.0020,
			"bettor": "sss",
			"rollunder": 20,
			"roll": 60,
			"payout": 29.8800
		}]
	}
}
```

5. api/v1/bets/savebetinfo   Post

保存bet信息

请求参数：
```url
{
  "bettor": "s99",
  "rollUnder": 10,
  "bet": 10.0004,
  "roll": 90,
  "payout": 100.888
}

```

响应例子：

```json
{
    "Action": "savebetinfo",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": 1
    }
}
```


6. api/v1/bets/savehugewin   Post

保存bet信息

请求参数：
```url
{
  "bettor": "s99",
  "rollUnder": 10,
  "bet": 10.0004,
  "roll": 90,
  "payout": 100.888
}

```

响应例子：

```json
{
    "Action": "inserthugewin",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": 1
    }
}
```