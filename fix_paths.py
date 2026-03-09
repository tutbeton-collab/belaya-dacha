import os
import re

BASE_PATH = '/belaya-dacha'
DIR = os.path.dirname(os.path.abspath(__file__))

def fix_paths_in_file(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()
    
    original = content
    
    # Исправляем пути к CSS в HTML
    content = re.sub(r'href="/_next/static/', f'href="{BASE_PATH}/_next/static/', content)
    
    # Исправляем пути к JS в HTML
    content = re.sub(r'src="/_next/static/', f'src="{BASE_PATH}/_next/static/', content)
    
    # Исправляем пути к изображениям в HTML
    content = re.sub(r'src="/images/', f'src="{BASE_PATH}/images/', content)
    content = re.sub(r'href="/images/', f'href="{BASE_PATH}/images/', content)
    
    # Исправляем пути в JSON данных (для Next.js hydration)
    # "static/chunks/ -> "/belaya-dacha/_next/static/chunks/
    content = re.sub(r'"static/chunks/', f'"{BASE_PATH}/_next/static/chunks/', content)
    
    # Исправляем пути к CSS в JSON (href:"/_next/static/css/ -> href:"/belaya-dacha/_next/static/css/)
    content = re.sub(r'href:"/_next/static/css/', f'href:"{BASE_PATH}/_next/static/css/', content)
    
    # Исправляем пути к изображениям в JSON (src:"/images/ -> src:"/belaya-dacha/images/)
    content = re.sub(r'src:"/images/', f'src:"{BASE_PATH}/images/', content)
    
    # Исправляем assetPrefix (пустой на "/belaya-dacha")
    content = re.sub(r'assetPrefix:""', f'assetPrefix:"{BASE_PATH}"', content)
    
    if content != original:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"Исправлен: {filepath}")
    else:
        print(f"Без изменений: {filepath}")

# Исправляем index.html
fix_paths_in_file(os.path.join(DIR, 'index.html'))

# Исправляем 404.html
fix_paths_in_file(os.path.join(DIR, '404.html'))

print("Готово!")
