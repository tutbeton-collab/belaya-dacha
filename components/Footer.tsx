export default function Footer() {
  const currentYear = new Date().getFullYear();
  
  return (
    <footer className="bg-farm-green text-white py-12">
      <div className="container mx-auto px-4">
        <div className="max-w-4xl mx-auto text-center">
          <div className="text-3xl font-bold mb-4">🌿 Белая Дача</div>
          <p className="text-lg opacity-90 mb-6">
            Семейная ферма натуральных овощей
          </p>
          
          <div className="flex justify-center space-x-6 mb-8">
            <a href="#about" className="opacity-80 hover:opacity-100 transition-opacity">
              О ферме
            </a>
            <a href="#vegetables" className="opacity-80 hover:opacity-100 transition-opacity">
              Овощи
            </a>
            <a href="#advantages" className="opacity-80 hover:opacity-100 transition-opacity">
              Преимущества
            </a>
            <a href="#contact" className="opacity-80 hover:opacity-100 transition-opacity">
              Контакты
            </a>
          </div>
          
          <div className="border-t border-white/20 pt-8">
            <p className="opacity-70 text-sm">
              © {currentYear} Семейная ферма &quot;Белая Дача&quot;. Все права защищены.
            </p>
            <p className="opacity-60 text-sm mt-2">
              Выращено с любовью ❤️ на живой земле
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
}
