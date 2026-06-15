
def generate(code: str, context: dict) -> dict:
    """
    Generates documentation for code
    """
    functions = [line for line in code.split('\n') if 'def ' in line]
    
    docs = []
    for func in functions:
        func_name = func.split('def ')[1].split('(')[0]
        docs.append(f"## {func_name}\n\n{func_name} function.\n")
    
    return {
        'documentation': '\n'.join(docs),
        'format': 'markdown'
    }
