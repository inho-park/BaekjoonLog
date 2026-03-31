now_year, now_month, now_day = map(int, input().split(' '))
dday_year, dday_month, dday_day = map(int, input().split(' '))
if now_year + 1000 < dday_year or (now_year + 1000 == dday_year and now_month < dday_month) or (now_year + 1000 == dday_year and now_month == dday_month and now_day <= dday_day):
    print("gg")
    exit()
answer = 0
while True:
    if now_year == dday_year and now_month == dday_month and now_day == dday_day:
        print("D-" + str(answer))
        break

    answer += 1
    now_day += 1
    
    if now_month in [1, 3, 5, 7, 8, 10, 12]:
        if now_day > 31:
            now_day = 1
            now_month += 1
    elif now_month in [4, 6, 9, 11]:
        if now_day > 30:
            now_day = 1
            now_month += 1
    else: 
        if (now_year % 4 == 0 and now_year % 100 != 0) or (now_year % 400 == 0):
            if now_day > 29:
                now_day = 1
                now_month += 1
        else:
            if now_day > 28:
                now_day = 1
                now_month += 1
    
    if now_month > 12:
        now_month = 1
        now_year += 1