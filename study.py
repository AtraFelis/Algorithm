from flask import Flask

@app.route('/') # / 페이지 라우팅 
def index():
    session_id = request.cookies.get('sessionid', None) # 쿠키에서 sessionid 조회
    try:
        username = session_storage[session_id] # session_storage에서 해당 sessionid를 통해 username 조회
    except KeyError:
        return render_template('index.html')

    return render_template('index.html', text=f'Hello {username}, {"flag is " + FLAG if username == "admin" else "you are not admin"}')
 