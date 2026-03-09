import Link from 'next/link';

export default function Header() {
  return (
    <header className="fixed top-0 left-0 right-0 z-50 bg-farm-cream/95 backdrop-blur-sm shadow-sm">
      <nav className="container mx-auto px-4 py-4 flex justify-between items-center">
        <Link href="/" className="text-2xl font-bold text-farm-green hover:text-farm-green-light transition-colors">
          🌿 Белая Дача
        </Link>
        <div className="hidden md:flex space-x-8">
          <Link href="#about" className="text-farm-brown hover:text-farm-green transition-colors">
            О ферме
          </Link>
          <Link href="#vegetables" className="text-farm-brown hover:text-farm-green transition-colors">
            Овощи
          </Link>
          <Link href="#advantages" className="text-farm-brown hover:text-farm-green transition-colors">
            Преимущества
          </Link>
          <Link href="#wholesale" className="text-farm-brown hover:text-farm-green transition-colors">
            Опт
          </Link>
          <Link href="#gallery" className="text-farm-brown hover:text-farm-green transition-colors">
            Галерея
          </Link>
          <Link href="#contact" className="text-farm-brown hover:text-farm-green transition-colors">
            Контакты
          </Link>
        </div>
        <Link 
          href="#contact" 
          className="bg-farm-green text-white px-6 py-2 rounded-full hover:bg-farm-green-light transition-colors"
        >
          Связаться
        </Link>
      </nav>
    </header>
  );
}
