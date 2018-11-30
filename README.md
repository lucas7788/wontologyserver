# ontologyserver

## Introduction


## 更新说明

增加接口 `getmybetsbypage`

接口 `getmybets` 变更成 `getmybetsbybettor`

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