while True:
    text = input()
    if text == "*":
        break
    flag = False
    for i in range(1,len(text)):
        s = set([])
        for k in range(len(text)-i):
            t = text[k] + text[k+i]
            if t in s:
                flag = True
            else:
                s.add(t)
        if flag == True:
            print(text + " is NOT surprising.")
            break
    else:
        print(text + " is surprising.")   

            
         
