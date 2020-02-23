import hashlib

class MD5Utils(object): 

    def encrypt(self, content):
        hl = hashlib.md5()
        hl.update(content)
        return hl.hexdigest()

