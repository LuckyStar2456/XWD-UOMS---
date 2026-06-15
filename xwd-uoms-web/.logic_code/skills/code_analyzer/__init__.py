
def analyze(code: str, context: dict) -> dict:
    """
    Analyzes code complexity and patterns
    """
    lines = code.split('\n')
    complexity = len([l for l in lines if 'if' in l or 'for' in l or 'while' in l])
    
    return {
        'lines': len(lines),
        'complexity': complexity,
        'suggestions': [
            'Consider breaking down complex functions',
            'Add more comments for complex logic'
        ]
    }
